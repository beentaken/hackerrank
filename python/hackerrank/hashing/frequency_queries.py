# Complete the freqQuery function below.

INSERT = 1
DELETE = 2
QUERY = 3


def freqQuery(queries):
    counts = {}
    frequencies = {}

    results = []

    query_num = 0

    for q in queries:
        query = q[0]
        val = q[1]

        if query == INSERT:
            # print('INSERT', val)
            if val in counts and counts[val] in frequencies:
                frequencies[counts[val]] -= 1

            if val not in counts:
                counts[val] = 1
            else:
                counts[val] += 1

            if counts[val] not in frequencies:
                frequencies[counts[val]] = 1
            else:
                frequencies[counts[val]] += 1

            # print('INSERTED', val, frequencies, counts)
        if query == DELETE:
            # print('DELETE', val)
            if val not in counts:
                continue

            if counts[val] > 0:
                frequencies[counts[val]] -= 1
                counts[val] -= 1
                if counts[val] not in frequencies:
                    frequencies[counts[val]] = 1
                else:
                    frequencies[counts[val]] += 1

            # print('DELETED', val, frequencies, counts)

        if query == QUERY:
            if val in frequencies and frequencies[val] > 0:
                # print('QUERY', query_num, val, 1, frequencies, counts)
                results.append(1)
            else:
                # print('QUERY', query_num, val, 0, frequencies, counts)
                results.append(0)

            query_num += 1

    return results


if __name__ == '__main__':
    assert [1, 0, 0, 0] == freqQuery([[2, 3], [1, 3], [1, 3], [3, 2], [3, 1], [2, 3], [2, 3], [3, 2], [3, 1]])

    assert [0, 1, 1] == freqQuery([[1, 3], [2, 3], [3, 2], [1, 4], [1, 5],
                                   [1, 5], [1, 4], [3, 2], [2, 4], [3, 2]])


    queries = []
    with open("input07.txt") as f:
        for line in f:
            queries.append(list(map(int, line.rstrip().split())))

    output = []
    with open("output07.txt") as f:
        for line in f:
            output.append(int(line.rstrip()))

    ans = freqQuery(queries)

    for i, pair in enumerate(zip(ans, output)):
        if pair[0] != pair[1]:
            print(i, pair)

    assert ans == output
