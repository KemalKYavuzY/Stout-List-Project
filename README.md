# StoutListProject
This project implements a custom data structure called StoutList, which is a chunked linked list where each node can store multiple elements. It optimizes list operations by reducing the overhead of individual node allocations while maintaining efficient access, insertion, and deletion.

## Features

- Custom `StoutList` class with support for efficient adding, removing, and sorting of elements.
- Implements both **insertion sort** and **bubble sort** for sorting elements in ascending and descending order.
- Uses an iterator (`StoutListIterator`) to traverse the list efficiently in both directions (forward and backward).
- Handles node splitting when a node exceeds its capacity and merges nodes when they are underutilized.

## How It Works

1. **Data Storage**: Data is stored in nodes, and each node can hold multiple elements (as defined by the `nodeSize`).
2. **Adding Elements**: When an element is added, the code checks if the node is full. If so, it splits the node and adds the element to the correct position.
3. **Removing Elements**: When an element is removed, the code checks if the node is underutilized (less than half full), and merges the node with its neighbors if necessary.
4. **Sorting**: The list can be sorted in ascending or descending order using insertion sort or bubble sort.

## Usage

You can use this project as a custom list implementation in Java. To add this to your project:

1. Clone the repository.
2. Include the `StoutList` source files in your `src` folder.
3. Compile and run your Java application, making use of the `StoutList` class.

### Example Usage

```java
StoutList<Integer> list = new StoutList<>();
list.add(5);
list.add(10);
list.add(3);
list.sort(); // Sort the list in ascending order
