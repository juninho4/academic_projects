from collections import defaultdict
from math import gcd

ciphertext = """
kyjzjegtedvnhuwgjitnxeuggkzmezwyvbhxprueiproeqppthkqqqwsjrstgulmvxcyqrofmejouwbpiwsmtmxbtcaztdntbyizszwurqeexgnguxvpkebrphoaqavstcbiekrbrqwckrpgmctwcxveetnhfgiacrletxurgkgtvftmsauaqgmeqsbhvwzjdgsfvtwjjczyyoivwzwcyfeemffcurqoezxfynsaagtrtauxecaweppxxvtitrxdfcgqqivseumagkgcydcrqgtmaiphgrcqqqxenlrivwjnyamahpcrsnysstsurjyaetkrovsdnvnviovhlfpvcrkrxlhhzkpqgfcsgnotivlymwugaifkwoiavmvfjgyvnnpialfukruevqblmeacftrfogmakwbefeivrpwcenyaitatbfuciwcgvqgdoovvpkprwcymtpgtrtauxecwtvkpurqtiqtssuzrdimaysywhdnmpyzzjnugqafecsahszpjynyekiacfcnmpwpieqjbietstrnynlrfseaklfpbhxprwzgeatixhgwcgnphprwolezcxqpqtzinufwgmlfsigviailjsykxqpfwfinfizqjdjmgglmeipuxuoezxnyaxugivqtqnlrrxwyjxumpfcvnxesgygsxnycuvroeqaxlhmpqrqpktayegapbxpfitcggptynmawiagtnutgwvmgmpjyonmkfnxukvpebvty
"""
print(ciphertext.upper())

def find_repeated_sequences(text, min_len=3, max_len=5):
    repeats = defaultdict(list)
    N = len(text)

    for L in range(min_len, max_len+1):
        seen = {}
        for i in range(N - L + 1):
            seq = text[i:i+L]
            if seq in seen:
                repeats[seq].append((seen[seq], i))   # store (first_pos, second_pos)
            else:
                seen[seq] = i
    return repeats

repeats = find_repeated_sequences(ciphertext)

def gcd_list(nums):
    return gcd(nums[0], gcd_list(nums[1:])) if len(nums) > 1 else nums[0]

gcds = []

for seq, positions in repeats.items():
    distances = [abs(b - a) for (a, b) in positions]
    if len(distances) > 0:
        print(f"Sequence: {seq}")
        print(f"  Occurrences: {positions}")
        print(f"  Distances: {distances}")
        print(f"  GCD of distances: {gcd_list(distances)}\n")
        gcds.append(gcd_list(distances))

gcds = []
for seq, positions in repeats.items():
    distances = [abs(b - a) for (a, b) in positions]
    gcds.append(gcd_list(distances))

for a in gcds:
    amount = 0
    for b in gcds:
        if b % a == 0:
            amount += 1
    print(f"{a} has {amount}")