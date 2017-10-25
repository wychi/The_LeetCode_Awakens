用在分群

# Array implementation
```java
// Naive implementation of find
int find(int parent[], int i)
{
    if (parent[i] == -1)
        return i;
    return find(parent, parent[i]);
}
  
// Naive implementation of union()
void Union(int parent[], int x, int y)
{
    int xset = find(parent, x);
    int yset = find(parent, y);
    parent[xset] = yset;
}
```

# Question
* [200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/)
* [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/description/)
