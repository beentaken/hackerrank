from collections import defaultdict


def countTriplets(arr, r):
    d = defaultdict(int)
    triplets = 0

    for x in arr:
        d[x] += 1

        if x // r in d and x // r // r in d:
            t = d[x // r] * d[x // r // r]
            triplets += t

    print(triplets)
    return triplets


if __name__ == '__main__':
    # assert 2 == countTriplets([1, 2, 2, 4], 2)
    # assert 6 == countTriplets([1, 3, 9, 9, 27, 81], 3)
    # assert 4 == countTriplets([1, 5, 5, 25, 125], 5)
    # assert 161700 == countTriplets([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    #                                 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    #                                 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    #                                 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    #                                 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 1)
    assert 6 == countTriplets([1, 1, 1, 1, 1], 1)
