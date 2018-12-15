def string_freq(s):
    h = {}
    for letter in s:
        if letter not in h:
            h[letter] = 1
        else:
            h[letter] += 1
    return h


def makeAnagram(a, b):
    a_dict = string_freq(a)
    b_dict = string_freq(b)

    a_set = set(a_dict.keys())
    b_set = set(b_dict.keys())

    to_delete = 0
    for letter in a_set.intersection(b_set):
        to_delete += abs(a_dict[letter] - b_dict[letter])

    for letter in a_set.difference(b_set):
        to_delete += a_dict[letter]

    for letter in b_set.difference(a_set):
        to_delete += b_dict[letter]

    return to_delete



if __name__ == '__main__':
    assert 4 == makeAnagram("cde", "abc")
