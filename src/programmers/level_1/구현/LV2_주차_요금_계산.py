from collections import deque 
import math
def solution(fees, records):
    
    bt,bf,ut,uf=fees
    records2=[]
    for r in records:
        time_s,num,st=r.split()
        h,m=list(map(int,time_s.split(':')))
        time=h*60+m
        records2.append([time,num,st])
    
    dc={}
    last_time={}
    total_time={}
    paid={}
    for r in records2:
        if r[2]=="IN":
            last_time[r[1]]=r[0]
            paid[r[1]]=False
        else:
            paid[r[1]]=True
            during=r[0]-last_time[r[1]]
            if not r[1] in total_time : total_time[r[1]]=0
            total_time[r[1]]+=during
            
    not_paid=[k for k,v in paid.items() if not v]
    for n in not_paid:
        during=(23*60+59-last_time[n])
        if not n in total_time : 
            total_time[n]=0
        total_time[n]+=during
        
            
    for k,v in total_time.items():
        if v<=bt: dc[k]=bf
        else : 
            dc[k]=bf+math.ceil((v-bt)/ut)*uf
    
    return list([ v for k,v in sorted(dc.items())])