from collections import deque
import sys

sys.setrecursionlimit(1000000)

class Node:
    def __init__(self,value,x,y,left=None,right=None,parent=None):
        self.parent=parent
        self.left=left
        self.right=right
        self.value=value 
        self.x=x
        self.y=y

def create_graph(root,node_info,new_nodes):
    
    nodes=[Node(i,v[0],v[1]) for i,v in enumerate(node_info)]
    
    for new_node in new_nodes:
        s=deque()
        s.append(nodes[root])
        
        ni=new_node[2]
        new=nodes[ni]
        
        while s:
            current=s.pop()
            
            if current.y>new.y: #밑으로 내려감
                if current.x>new.x: #왼쪽의 경우
                    if current.left==None:
                        current.left=new
                        new.parent=current
                        break
                    else:
                        s.append(current.left)
                else:
                    if current.right==None:
                        current.right=new
                        new.parent=current
                        break
                    else:
                        s.append(current.right)
                        
    return nodes
                
    
def pre_order(graph,current,path=[]):
    
    path.append(current.value+1)
    
    if current.left!=None:
        pre_order(graph,current.left,path)
    if current.right!=None:
        pre_order(graph,current.right,path)
    return path

def post_order(graph,current,path=[]):
    
    if current.left!=None:
        post_order(graph,current.left,path)
    if current.right!=None:
        post_order(graph,current.right,path)
    path.append(current.value+1)
    return path
       

def solution(nodeinfo):
    nodes=[]
    for i,(x,y) in enumerate(nodeinfo):
        nodes.append((-y,x,i,x,y))
    nodes.sort()
    root=nodes[0][2]
    
    graph=create_graph(root,nodeinfo,nodes)
    
    pre=pre_order(graph,graph[root])
    post=post_order(graph,graph[root])
    
    answer = [pre,post]
    return answer