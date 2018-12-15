
# Complete the countingValleys function below.
def countingValleys(n, s):

    altitude = 0
    valleys = 0

    for step in s:
        if step == "U":
            altitude += 1
            if altitude == 0:
                valleys += 1
        elif step == "D":
            altitude -= 1

    return valleys


if __name__ == "__main__":
    assert 1 == countingValleys(8, "UDDDUDUU")
    assert 1 == countingValleys(8, "DDUUUUDD")
