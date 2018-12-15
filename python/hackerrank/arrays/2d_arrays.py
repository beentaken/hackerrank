# Complete the hourglassSum function below.
import sys


def hourglassSum(arr):
    hg_max = -sys.maxsize - 1
    offsets = [[0, 0], [0, 1], [0, 2], [1, 1], [2, 0], [2, 1], [2, 2]]
    for x in range(0, len(arr) - 2):
        for y in range(4):

            hg_sum = 0
            for o in offsets:
                hg_sum += arr[x + o[0]][y + o[1]]
            if hg_sum > hg_max:
                hg_max = hg_sum

    return hg_max


if __name__ == '__main__':
    assert 19 == hourglassSum(
        [[1, 1, 1, 0, 0, 0],
         [0, 1, 0, 0, 0, 0],
         [1, 1, 1, 0, 0, 0],
         [0, 0, 2, 4, 4, 0],
         [0, 0, 0, 2, 0, 0],
         [0, 0, 1, 2, 4, 0]])
