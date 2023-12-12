import requests
import os
import configparser as parser
import re
import dotenv
import json


class Problem:
    def __init__(self,title,id,lan,platform,level,memo=""):
        self.title=title
        self.id=id
        self.lan=lan
        self.platform=platform
        self.level=level
        self.memo=memo

    def __str__(self):
        return f"Title: {self.title}, ID: {self.id}, Language: {self.lan}, Platform: {self.platform}, Level: {self.level}, Memo: {self.memo}"
        
def request_notion_update(problem:Problem):

    try:
        print(f"\nRequest add new file to notion db : {problem.id} {problem.title}...")
        response=requests.post(REQUEST_URL,problem.__dict__)
        if response.status_code==200:
            print("Successfully request\n")
        else:
            print(f"Request fail : {response.status_code} {response.text}\n")

    except Exception as e:
        print("An error occurred:", e)


if __name__=="__main__":

    local_feed_url=""
    local_request_url=""

    if os.path.isfile('.env'):
        print("load local .env")
        dotenv.load_dotenv()
        local_request_url=os.getenv('request_url')
        local_commit_msg=os.getenv('commit_msg')
        local_pattern=os.getenv('commit_pattern')
        
    
    REQUEST_URL = os.environ['REQUEST_URL'] if os.environ.get('REQUEST_URL') != None else local_request_url
    COMMIT_MSG = os.environ['COMMIT_MSG'] if os.environ.get('COMMIT_MSG') != None else local_commit_msg
    PATTERN=os.environ['COMMIT_PATTERN'] if os.environ.get('COMMIT_PATTERN')!=None else local_pattern
    
    print(PATTERN)
    match=re.match(PATTERN,COMMIT_MSG)
    print(match)

    if match:
        op, platform, level, id, title,lan = match.groups()
        problem=Problem(
            title=title,
            id=id,
            lan=lan,
            platform=platform,
            level=level
        )
       
        if op=="solve": request_notion_update(problem)

    else:
        print("not solve commit or parsing failed")

