from collections import defaultdict


def checkMagazine(magazine, note):
    m_dict = defaultdict(int)
    for word in magazine:
        m_dict[word] += 1

    n_dict = defaultdict(int)
    for word in note:
        n_dict[word] += 1

    for k, count in n_dict.items():
        if m_dict[k] < count:
            return "No"

    return "Yes"


if __name__ == '__main__':
    assert "Yes" == checkMagazine(["give", "me", "one", "grand", "today", "night"],
                                  ["give", "one", "grand", "today"])
    assert "No" == checkMagazine(["two", "times", "three", "is", "not", "four"],
                                 ["two", "times", "two", "is", "four"])
    assert "No" == checkMagazine(["ive", "got", "a", "lovely", "bunch", "of", "coconuts"],
                                 ["ive", "got", "some", "coconuts"])
