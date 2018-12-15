def minimumSwaps(arr):
    n = len(arr)
    swaps = 0
    i = 0
    while i < n:
        if arr[i] != i + 1:
            arr[arr[i] - 1], arr[i] = arr[i], arr[arr[i] - 1]
            swaps += 1
        else:
            i += 1

    return swaps


if __name__ == '__main__':
    assert 3 == minimumSwaps([1, 3, 5, 2, 4, 6, 7])
    assert 3 == minimumSwaps([2, 3, 4, 1, 5])
    assert 3 == minimumSwaps([4, 3, 1, 2])
    assert 5 == minimumSwaps([7, 1, 3, 2, 4, 5, 6])
