def repeatedString(s, n):
    count_a = s.count("a")

    repeats = n // len(s)
    mod = n % len(s)
    count_mod = s[:mod].count("a")

    return count_a * repeats + count_mod


if __name__ == '__main__':
    assert 7 == repeatedString("aba", 10)
    assert 1000000000000 == repeatedString("a", 1000000000000)
