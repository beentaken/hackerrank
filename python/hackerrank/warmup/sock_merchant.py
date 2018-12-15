from collections import defaultdict


def sockMerchant(n, ar):
    d = defaultdict(int)

    for s in ar:
        d[s] += 1

    total = 0
    for v in d.values():
        total += v // 2

    return total


if __name__ == "__main__":
    assert 3 == sockMerchant(9, [10, 20, 20, 10, 10, 30, 50, 10, 20])
