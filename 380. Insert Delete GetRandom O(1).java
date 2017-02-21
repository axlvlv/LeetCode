/*
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

设计一个数据结构支持在O(1)时间内完成如下操作：

insert(val): 如果集合中不包含val，则插入val

remove(val): 如果集合中包含val，则移除val

getRandom: 从现有集合中随机返回一个元素，每个元素被返回的概率应该相等
/*

/*
insert(val): 将val添至dataList末尾，并在dataMap中保存val的下标idx

remove(val): 记val的下标为idx，dataList末尾元素为tail，弹出tail并将其替换至idx处，在dataMap中更新tail的下标为idx，最后从dataMap中移除val

getRandom: 从dataList中随机选取元素返回

由于哈希表的删除是常数时间的，而数组并不是，为了使数组删除也能常数级，
我们实际上将要删除的数字和数组的最后一个数字调换个位置，然后修改对应的哈希表中的值，
这样我们只需要删除数组的最后一个元素即可，保证了常数时间内的删除。

