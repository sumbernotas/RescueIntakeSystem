# Enhanced Rescue Animal Management System

## Project Overview

This project represents a significant enhancement of a rescue animal management system that was created in my IT-145 course, demonstrating advanced data structures and algorithms implementation. The system has been upgraded from a basic ArrayList-based storage system to a sophisticated binary search tree architecture, providing dramatic performance improvements and expanded functionality.

The original project can be found [here](https://github.com/sumbernotas/PetBag)

## Enhancement Category: Data Structures and Algorithms

### Original System Limitations
- **Limited animal types**: Only dogs and monkeys supported
- **Linear search performance**: O(n) time complexity for all operations
- **Basic functionality**: Simple intake and reservation features
- **No advanced search capabilities**: Limited filtering options
- **Poor scalability**: Performance degrades with larger datasets

### Enhanced System Improvements
- **Expanded animal support**: Dogs, Monkeys, Cats, and Birds
- **Binary Search Tree implementation**: O(log n) search performance
- **Advanced multi-criteria search**: Filter by status, country, age range
- **Professional architecture**: Proper package organization and separation of concerns
- **Enhanced validation**: Comprehensive input validation and error handling
- **Performance monitoring**: Tree height analysis and efficiency metrics

## Technical Architecture

### Project Structure
```
src/
├── Driver.java                    # Main application interface
├── animals/                       # Animal classes package
│   ├── RescueAnimal.java         # Enhanced abstract base class
│   ├── Dog.java                  # Enhanced dog implementation
│   ├── Monkey.java               # Enhanced monkey implementation
│   ├── Cat.java                  # New cat implementation
│   └── Bird.java                 # New bird implementation
└── datastructures/               # Data structures package
    ├── AnimalBinaryTree.java     # Generic binary search tree
    └── AnimalTreeManager.java    # Tree management system
```

### Key Data Structures

#### Binary Search Tree (`AnimalBinaryTree<T>`)
- **Generic implementation** supporting any RescueAnimal subtype
- **O(log n) search, insertion, and deletion** operations
- **In-order traversal** for automatic alphabetical sorting
- **Multi-criteria search** capabilities
- **Tree performance analysis** features

#### Tree Manager (`AnimalTreeManager`)
- **Unified interface** for managing multiple animal types
- **Separate trees** for optimal type-specific performance
- **Cross-tree search** capabilities
- **Efficient reservation** system
- **Comprehensive statistics** generation

## Algorithm Improvements

### Performance Comparison

| Operation | Original System | Enhanced System | Improvement |
|-----------|----------------|-----------------|-------------|
| Animal Search | O(n) linear | O(log n) binary | ~10x faster |
| Duplicate Check | O(n) scan | O(log n) tree | ~10x faster |
| Sorted Display | O(n log n) sort | O(n) traversal | Built-in sorting |
| Multi-criteria Filter | O(n) per criteria | O(n) tree traversal | Optimized access |

### Search Algorithms Implemented
1. **Binary Search by Name**: O(log n) animal lookup
2. **Tree Traversal Search**: Efficient criteria-based filtering
3. **Range Queries**: Age and measurement-based searches
4. **Status Filtering**: Training status and availability queries

## Enhanced Features

### Animal Management
- **Four animal types** with specialized attributes
- **Advanced validation** for species-specific requirements
- **Automatic ID generation** and duplicate prevention
- **Professional error handling** with meaningful messages

### Search Capabilities
- **Lightning-fast name lookup**: O(log n) binary search
- **Multi-criteria filtering**: Status, country, age range
- **Cross-type searches**: Query all animals simultaneously
- **Available animal queries**: Service-ready animal identification

### System Monitoring
- **Tree performance metrics**: Height and balance analysis
- **Statistical reporting**: Comprehensive system overview
- **Performance comparison**: Before/after algorithm analysis

## Installation and Usage

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java IDE (recommended: VSCode, IntelliJ IDEA, or Eclipse)

### Compilation
```bash
javac -cp src src/Driver.java src/animals/*.java src/datastructures/*.java
```

### Execution
```bash
java -cp src Driver
```

### Menu Navigation
The enhanced system provides an intuitive menu-driven interface:
1. **Animal Intake** (Options 1-4): Add new animals with validation
2. **Reservation Management** (Option 5): Reserve available animals
3. **Viewing Options** (Options 6-10): Display animals with tree-sorted output
4. **Enhanced Search** (Options 11-13): Advanced search and analysis feature

## Key Enhancements Demonstrated

### 1. Data Structure Sophistication
- **From ArrayLists to Binary Search Trees**
- **Generic programming** with type-safe implementations
- **Professional architecture** with package organization

### 2. Algorithm Optimization
- **Search complexity reduction**: O(n) → O(log n)
- **Automatic sorting** through tree structure
- **Efficient multi-criteria filtering**

### 3. System Scalability
- **Doubled animal type support**: 2 → 4 types
- **Extensible architecture** for future animal additions
- **Performance monitoring** for optimization insights

### 4. Software Engineering Practices
- **Comprehensive documentation** with JavaDoc
- **Input validation** and error handling
- **Separation of concerns** with proper packaging
- **Object-oriented design** principles

## Performance Analysis

### Sample Performance Metrics
With 100 animals in the system:
- **ArrayList search**: Up to 100 comparisons
- **Binary tree search**: Maximum 7 comparisons
- **Performance improvement**: ~14x faster searches

### Tree Structure Efficiency
The system monitors tree height to ensure optimal performance:
- **Balanced trees**: Height ≈ log₂(n)
- **Performance alerts**: Height monitoring for degradation detection
- **Efficiency metrics**: Real-time performance analysis


## Conclusion

This enhanced rescue animal management system demonstrates a comprehensive understanding of data structures and algorithms, showcasing significant performance improvements through the implementation of binary search trees. The system successfully balances functionality, performance, and maintainability while providing a solid foundation for future enhancements.

The project effectively illustrates the practical application of computer science principles in solving real-world problems, demonstrating both technical proficiency and software engineering best practices.

---

## Author

**Summer Bernotas**  
Computer Science Student  
Southern New Hampshire University  
Capstone Project - Enhancement #2 

---

**Last Updated:** September 2025  
**Version:** 2.0.0  
**Status:** Complete - Ready for Capstone Submission
