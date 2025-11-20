/* 155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output:
[null,null,null,null,-3,null,0,-2]

Explanation:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2 */


class MinStack {
    ArrayList<Integer> list;
    ArrayList<Integer> minList;

    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if (minList.size() == 0 || val <= minList.get(minList.size()-1)) {
            minList.add(val);
        }
    }
    
    public void pop() {
        if (list.get(list.size()-1).equals(minList.get(minList.size()-1))) {
            minList.remove(minList.size()-1);
        }
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return minList.get(minList.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/* 
Time Complexities:
    push() - O(1)
    pop() - O(1)
    top() - O(1)
    getMin() - O(1)

Space Complexity: O(n)
 */