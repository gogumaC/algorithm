import requests
import os
import configparser as parser
import re
import dotenv
import json
import sys


class Problem:

    def __init__(self,title,lan,platform,level):
        self.title=title
        self.lan=lan
        self.platform=platform
        self.level=level

    def __str__(self):
        return f"Title: {self.title}, Language: {self.lan}, Platform: {self.platform}, Level: {self.level}"
        
def request_notion_update(body):

    try:
        print(f"\nRequest add new file to notion db...")
        response=requests.post(REQUEST_URL,body)
        if response.status_code==200:
            print("Successfully request\n")
            return True
        else:
            print(f"Request fail : {response.status_code} {response.text}\n")
            return False

    except Exception as e:
        print("An error occurred:", e)

def parse_commit_msg(msg,pattern):
    lines=msg.split("\n")
    head=lines[0]
    match=re.match(pattern,head)
    if match:
        _, platform, level, title,lans = match.groups()
        problem=Problem(
            title=title,
            lan=[lan for lan in lans.split('_')],
            platform=platform,
            level=level
        )
        details={}
        if len(lines)>3:
            rest=lines[2:]
            key_value_pattern=r"^([a-zA-Z0-9_]+)\s*:\s*(.*)$"
            
            for str in rest:
                key_value_match=re.match(key_value_pattern,str)
                if key_value_match:
                    key,value=key_value_match.groups()
                    if not value.strip():
                        continue
                    if "[" in value:
                        value=value.replace("[","").replace("]","")
                        value=list(map(lambda x: x.strip(),value.split(",")))  
                    if value=='true' or value=='false':
                        value=bool(value)
                    if key in ['time','try']:
                        value=int(value)
                    details[key]=value

        request_body={**problem.__dict__, **details}

        print("parsing success!")
        return request_body  
    else:
        print("no match")

        
if __name__=="__main__":

    local_feed_url=""
    local_request_url=""

    if os.path.isfile('.env'):
        dotenv.load_dotenv()
        local_request_url=os.getenv('request_url')
        local_commit_msg=os.getenv('commit_msg')
        local_pattern=os.getenv('commit_pattern')
    
    REQUEST_URL = os.environ['REQUEST_URL'] if os.environ.get('REQUEST_URL') != None else local_request_url
    COMMIT_MSG = os.environ['COMMIT_MSG'] if os.environ.get('COMMIT_MSG') != None else local_commit_msg
    PATTERN=os.environ['COMMIT_PATTERN'] if os.environ.get('COMMIT_PATTERN')!=None else local_pattern

    print("commit : ",COMMIT_MSG,"\n")

    body=parse_commit_msg(COMMIT_MSG,PATTERN)
    print(body)
    result=request_notion_update(body)
    if not result:
        sys.exit(1)
