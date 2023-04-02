# Java8

Stream
Introduction

Stream is used to simplified the logic and reduces the code. It reduces the cognitive complexity. Stream basically is composing functions and execute in data flow.

The general flow of stream is illustrate below

Streams data -> filter -> transformation {} -> output

Operations

There two types of operation in Streams
Non-terminal
**filter()**
filter is used to basically filtered the data from the stream of list for the given filter criteria.
Code example

// Obtain a list of products belongs to category “Cloth” with price <= 1500

return originalList.stream()
.filter(product -> product.category.equals(ProductCategory.CLOTH))
.filter(product -> product.getPrice() <= 1500)
.collect(Collectors.toList());


**map()**
**flatMap()**
**distinct**
**sort()**
**peek**
operation peek() allows execution of system logic as part of a stream flow.
Terminal
**collect()**
**distinct()**
**min()**
**anymatch()**
**max()**
**sum()**
**average()**
**findFirst()**