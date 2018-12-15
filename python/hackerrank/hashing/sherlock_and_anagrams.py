from collections import defaultdict


def get_all_substrings(input_string):
    length = len(input_string)
    return [input_string[i:j + 1] for i in range(length) for j in range(i, length)]


def sherlockAndAnagrams(s):
    d = defaultdict(int)
    subs = get_all_substrings(s)
    for sub in subs:
        d[''.join(sorted(sub))] += 1

    c = 0
    for v in d.values():
        v -= 1
        c += (v * (v + 1)) / 2

    return int(c)


if __name__ == '__main__':
    assert 4 == sherlockAndAnagrams("abba")
    assert 0 == sherlockAndAnagrams("abcd")
    assert 3 == sherlockAndAnagrams("ifailuhkqq")
    assert 10 == sherlockAndAnagrams("kkkk")
    assert 5 == sherlockAndAnagrams("cdcd")
