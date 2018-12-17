from collections import Counter


def countTriplets(arr, r):
    r2 = Counter()
    r3 = Counter()
    count = 0

    for v in arr:
        if v in r3:
            count += r3[v]

        if v in r2:
            r3[v * r] += r2[v]

        r2[v * r] += 1

    print(count)
    return count


if __name__ == '__main__':
    assert 2 == countTriplets([1, 2, 2, 4], 2)
    assert 6 == countTriplets([1, 3, 9, 9, 27, 81], 3)
    assert 4 == countTriplets([1, 5, 5, 25, 125], 5)
    assert 161700 == countTriplets([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 1)
