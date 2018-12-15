# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
    i = 0
    jumps = 0
    while True:
        if i + 2 == len(c):
            i += 1
        elif c[i + 2] == 1:
            i += 1
        else:
            i += 2

        jumps += 1

        if len(c) - 1 == i:
            break

    return jumps


if __name__ == '__main__':
    assert 4 == jumpingOnClouds([0, 0, 1, 0, 0, 1, 0])
    assert 4 == jumpingOnClouds([0, 0, 0, 0, 1, 0, 0])
