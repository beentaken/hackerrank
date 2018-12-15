def twoStrings(s1, s2):
    s1 = set(list(s1))
    s2 = set(list(s2))

    if s1.intersection(s2):
        return "YES"
    return "NO"


if __name__ == '__main__':
    print(twoStrings("hello", "world"))
    print(twoStrings("hi", "world"))
