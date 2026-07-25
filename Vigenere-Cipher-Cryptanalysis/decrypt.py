ciphertext = "kyjzjegtedvnhuwgjitnxeuggkzmezwyvbhxprueiproeqppthkqqqwsjrstgulmvxcyqrofmejouwbpiwsmtmxbtcaztdntbyizszwurqeexgnguxvpkebrphoaqavstcbiekrbrqwckrpgmctwcxveetnhfgiacrletxurgkgtvftmsauaqgmeqsbhvwzjdgsfvtwjjczyyoivwzwcyfeemffcurqoezxfynsaagtrtauxecaweppxxvtitrxdfcgqqivseumagkgcydcrqgtmaiphgrcqqqxenlrivwjnyamahpcrsnysstsurjyaetkrovsdnvnviovhlfpvcrkrxlhhzkpqgfcsgnotivlymwugaifkwoiavmvfjgyvnnpialfukruevqblmeacftrfogmakwbefeivrpwcenyaitatbfuciwcgvqgdoovvpkprwcymtpgtrtauxecwtvkpurqtiqtssuzrdimaysywhdnmpyzzjnugqafecsahszpjynyekiacfcnmpwpieqjbietstrnynlrfseaklfpbhxprwzgeatixhgwcgnphprwolezcxqpqtzinufwgmlfsigviailjsykxqpfwfinfizqjdjmgglmeipuxuoezxnyaxugivqtqnlrrxwyjxumpfcvnxesgygsxnycuvroeqaxlhmpqrqpktayegapbxpfitcggptynmawiagtnutgwvmgmpjyonmkfnxukvpebvty"
ciphertext = ciphertext.upper()

key = "INFLUENCE"

alphabets = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
             'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
             'Y', 'Z']

i = 0
result = ""
while i < len(ciphertext):
    letter = alphabets.index(ciphertext[i])
    letter_key = alphabets.index(key[i % 9])
    a = (letter - letter_key) % 26
    alphabet = alphabets[a]
    result += alphabet
    i = i + 1

print(result)


