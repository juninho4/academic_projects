from collections import Counter
KEY_LENGTH = 9

# English letter frequency
ENGLISH = {
    'A': 8.167, 'B': 1.492, 'C': 2.782, 'D': 4.253, 'E': 12.702,
    'F': 2.228, 'G': 2.015, 'H': 6.094, 'I': 6.966, 'J': 0.153,
    'K': 0.772, 'L': 4.025, 'M': 2.406, 'N': 6.749, 'O': 7.507,
    'P': 1.929, 'Q': 0.095, 'R': 5.987, 'S': 6.327, 'T': 9.056,
    'U': 2.758, 'V': 0.978, 'W': 2.360, 'X': 0.150, 'Y': 1.974,
    'Z': 0.074
}

alphabets = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
             'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
             'Y', 'Z']

def chi_square(text):
    N = len(text)
    counts = Counter(text)
    chi = 0.0

    for letter in alphabets:
        observed = counts.get(letter, 0)
        expected = ENGLISH[letter] * N / 100.0
        chi += (observed - expected) ** 2 / expected if expected > 0 else 0

    return chi

def shift_text(text, shift):
    shifted = ""
    for ch in text:
        shifted += alphabets[((alphabets.index(ch) - shift) % 26)]
    return shifted

def analyze_column(column):
    # return chi-square scores for all possible caesar shifts.
    scores = []
    for s in range(26):
        shifted = shift_text(column, s)
        chi = chi_square(shifted)
        scores.append((s, chi))
    return scores

ciphertext = "kyjzjegtedvnhuwgjitnxeuggkzmezwyvbhxprueiproeqppthkqqqwsjrstgulmvxcyqrofmejouwbpiwsmtmxbtcaztdntbyizszwurqeexgnguxvpkebrphoaqavstcbiekrbrqwckrpgmctwcxveetnhfgiacrletxurgkgtvftmsauaqgmeqsbhvwzjdgsfvtwjjczyyoivwzwcyfeemffcurqoezxfynsaagtrtauxecaweppxxvtitrxdfcgqqivseumagkgcydcrqgtmaiphgrcqqqxenlrivwjnyamahpcrsnysstsurjyaetkrovsdnvnviovhlfpvcrkrxlhhzkpqgfcsgnotivlymwugaifkwoiavmvfjgyvnnpialfukruevqblmeacftrfogmakwbefeivrpwcenyaitatbfuciwcgvqgdoovvpkprwcymtpgtrtauxecwtvkpurqtiqtssuzrdimaysywhdnmpyzzjnugqafecsahszpjynyekiacfcnmpwpieqjbietstrnynlrfseaklfpbhxprwzgeatixhgwcgnphprwolezcxqpqtzinufwgmlfsigviailjsykxqpfwfinfizqjdjmgglmeipuxuoezxnyaxugivqtqnlrrxwyjxumpfcvnxesgygsxnycuvroeqaxlhmpqrqpktayegapbxpfitcggptynmawiagtnutgwvmgmpjyonmkfnxukvpebvty"
ciphertext = ciphertext.upper()
# break into 9 columns
columns = [ciphertext[i::KEY_LENGTH] for i in range(KEY_LENGTH)]
print(columns)

for i, col in enumerate(columns):
    results = analyze_column(col)
    results = sorted(results, key=lambda x:x[1])
    print(f"Letter index: {i}")
    print(alphabets[results[0][0]])