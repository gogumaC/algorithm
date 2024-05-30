hp = 0
count = 0


def solution(bandage, health, attacks):
    global hp
    hp = health
    answer = 0
    attack_count = 0
    t = 1
    atts = {}
    for a in attacks:
        atts[a[0]] = a[1]

    while True:
        if t in atts:
            attack_count += 1
            attacked(atts[t])
        else:
            banding(bandage, health)
        if hp <= 0:
            answer = -1
            break
        if attack_count >= len(attacks):
            answer = hp
            break
        t += 1

    return answer


def banding(bandage, health):
    global count, hp
    count += 1
    hp += bandage[1]
    if count == bandage[0]:
        hp += bandage[2]
        count = 0
    if hp >= health:
        hp = health
        return


def attacked(damage):
    global hp, count
    hp -= damage
    count = 0
