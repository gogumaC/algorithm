# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N):
    bs=f"{bin(N)}"[2:]
    zeros=bs.split("1")
    if N%2==0:
        zeros.pop()
    result=max([len(z) for z in zeros]) if zeros else 0
    return result