# Paging in an Operating System
Program to simulate paging in operating system using Optimal algorithm and Least Recently Used algorithm.
In an operating system that uses paging for memory management, a page replacement algorithm is needed to decide which page needs to be replaced when new page comes in. 
## Page Fault
A page fault occurs when there has been made an access to a page that is mapped into the virtual memory but is not loaded in the physical memory.Since size of physical memory is smaller than virtual memory, page faults will occur.So the operating system will have to replace some of the pages already loaded in the physical memory and there has to be designed an algorithm which can help the OS to decide which page to replace.

## There are three such algorithms
- FIFO:This is the simplest page replacement algorithm. In this algorithm, the operating system keeps track of all pages in the memory in a queue, the oldest page is in the front of the queue. When a page needs to be replaced page in the front of the queue is selected for removal.
- LRU: In this algorithm page will be replaced which is least recently used. 
- Optimal: In this algorithm, pages are replaced which would not be used for the longest duration of time in the future.

# Input Specifications:
First Number of pages needs to specified.
A reference String (integers sperated by spaces) denoting the pages should be specified after that.
Number of frames, that is capacity of physical memory should be specified.
# Simulation
- Hit: Requested page was loaded in the memory.
- Miss: Page was not found in the memory.That means page fault has occured.
- Page Fualts: Number of misses.
