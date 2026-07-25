from collections import Counter

candidates = [9, 225, 18, 19]

ciphertext = """
kyjzjegtedvnhuwgjitnxeuggkzmezwyvbhxprueiproeqppthkqqqwsjrstgulmvxcyqrofmejouwbpiwsmtmxbtcaztdntbyizszwurqeexgnguxvpkebrphoaqavstcbiekrbrqwckrpgmctwcxveetnhfgiacrletxurgkgtvftmsauaqgmeqsbhvwzjdgsfvtwjjczyyoivwzwcyfeemffcurqoezxfynsaagtrtauxecaweppxxvtitrxdfcgqqivseumagkgcydcrqgtmaiphgrcqqqxenlrivwjnyamahpcrsnysstsurjyaetkrovsdnvnviovhlfpvcrkrxlhhzkpqgfcsgnotivlymwugaifkwoiavmvfjgyvnnpialfukruevqblmeacftrfogmakwbefeivrpwcenyaitatbfuciwcgvqgdoovvpkprwcymtpgtrtauxecwtvkpurqtiqtssuzrdimaysywhdnmpyzzjnugqafecsahszpjynyekiacfcnmpwpieqjbietstrnynlrfseaklfpbhxprwzgeatixhgwcgnphprwolezcxqpqtzinufwgmlfsigviailjsykxqpfwfinfizqjdjmgglmeipuxuoezxnyaxugivqtqnlrrxwyjxumpfcvnxesgygsxnycuvroeqaxlhmpqrqpktayegapbxpfitcggptynmawiagtnutgwvmgmpjyonmkfnxukvpebvty
"""

def ioc(text):
    counts = Counter(text)
    N = len(text)
    if N <= 1:
        return 0

    return sum(f*(f-1) for f in counts.values()) / (N*(N-1))

def ioc_full(ciphertext, candidates):
    results = {}
    for c in candidates:
        # group of words that are candidates long
        groups = [ciphertext[i::c] for i in range(c)]
        # compute the ioc for each word
        iocs = [ioc(g) for g in groups]
        # average ioc
        results[c] = sum(iocs) / len(iocs)
    return results

results = ioc_full(ciphertext, candidates)

print(results)

