class Solution:
    def leftmostBuildingQueries(self, heights: List[int], queries: List[List[int]]) -> List[int]:
        n = len(queries)
        res = [-1] * n

        groups = defaultdict(list)   # stores {hi: (required_height, query_ind)}

        for i, query in enumerate(queries):
            # sort indices of query
            lo, hi = sorted(query)

            # update res if found a right order
            if lo == hi or heights[lo] < heights[hi]:
                res[i] = hi

            # otherwise, add to the groups
            else:
                h = max(heights[lo], heights[hi])
                groups[hi] += [(h, i)]

        minhpq = []         # stores (q_h, q_i) increasingly

        for i, h in enumerate(heights):
            
            # add all the pairs in groups[i]
            for q_h, q_i in groups[i]:
                heappush(minhpq, (q_h, q_i))

            # clean up if violates the condition
            while minhpq and minhpq[0][0] < h:
                q_h, q_i = heappop(minhpq)
                res[q_i] = i

        return res