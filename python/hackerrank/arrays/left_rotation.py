def rotLeft(a, d):
    ret = [None] * len(a)
    for i, v in enumerate(a):
        ret[i - d] = v
    return ret


if __name__ == '__main__':
    assert [5, 1, 2, 3, 4] == rotLeft([1, 2, 3, 4, 5], 4)
