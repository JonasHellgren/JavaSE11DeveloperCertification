# Streams and lambda expressions


- A functional interface has a single abstract method. Can be seen as a way of providing code instead of data.
- A lambda expression implements a functional interface. It is an anonymous method.

We can sort a list by using sort method. Sore method uses a comparator that can be defined by a Lambda expression.       

        List<Product> products = ExampleData.getProducts();
        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

An interface can be a filter, later used to extract a sub list

    interface ProductFilter {
        boolean accept(Product product);
    }

    __________________

    ProductFilter filter = product -> product.getPrice().compareTo(priceLimit) < 0; //"defining" accept method

    __________________
    // Print the products that are accepted by the filter.
    static void printProducts(List<Product> products, ProductFilter filter) {
        for (Product product : products) {
            if (filter.accept(product)) {
                System.out.println(product);
            }
        }
    }

In general, avoid side effects such as modifying objects from captured variables in lambda expressions. Following is not clean.

        List<Product> cheapProducts = new ArrayList<>();
        products.forEach(product -> {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });


Instead of a lambda expression, you can use a method reference to refer to a method that implements the relevant functional interface. Following are hence equal:

        products.forEach(product -> System.out.println(product));
        products.forEach(System.out::println);

Examples of standard functional interfaces are:
- Function  (object out type T in, object of type R out)
- Consumer  (in is object, no out)
- Supplier  (no in, out is object)
- Predicate  (in is object out is booolean)
- BiFunction  (two objects that can be of different types as in, one out)
- BiConsumer (two objects that can be of different types as in, no one - handy for ex printing hash maps)
- BiPredicate (two objects that can be of different types as in, one boolean out)
  
Combining funtions and predicates:
- andThen, for combining two funtions
- and, for combining two predicates


Stream have Intermediate and Terminal operations. Ex on intermediate are filter and map. Ex on final are forEach.
Streams are lazy - without a terminal operation, no work is done

Differences collections and streams:
- Collection stores elements in a data structure, not valid for streams.
- Eager evaluation in collection, not valid for streams.
- Imperative programming for collections, functional for streams.
- Collection modifies data, streams does not modify its source.
- Streams applies internal iteration
- Streams can be infinite

When builder is used, the desired type should be additionally specified in the right part of the statement, otherwise the build() method will create an instance of the Stream<Object>.
The generate() method accepts a Supplier<T> for element generation. As the resulting stream is infinite, the developer should specify the desired size.
The range(int startInclusive, int endExclusive) method creates an ordered stream from the first parameter to the second parameter. It increments the value of subsequent elements with the step equal to 1. The result doesn't include the last parameter, it is just an upper bound of the sequence.
The rangeClosed(int startInclusive, int endInclusive) method does the same thing with only one difference, the second element is included. We can use these two methods to generate any of the three types of streams of primitives.

One can search in streams by:
- findFirst() or findAny()
- anyMatch(...), allMatch(...), noneMatch(...)
  
Collect single item:
- min, max

Common intermediate operations:
- filter, filters elements from the stream by boolean expression
- map, does a one-to-one transformation on each element
- flatMap, flatMap() is the combination of a map and a flat operation i.e, it first applies map function and then flattens the result.

Using collect() you can collect the elements of a stream into a collection, forEach(...add) is not clean. Two collect examples:
 - Collectors.toList(), for list collection
 - Collectors.joining(..), to reduce into a string

A collect() operation reduces a stream into a mutable result container. Immutable reduction is done by reduce().

The three parameters of the collect() function are:
- supplier: a function that creates a new mutable result container. For the parallel execution, this function may be called multiple times and it must return a fresh value each time.
- accumulator is a stateless function that must fold an element into a result container.
- combiner is a stateless function that accepts two partial result containers and merges them, which must be compatible with the accumulator function.


       return products.
                stream().
                collect(
                        TreeSet::new,  //a new mutable result container
                        (list, product) -> list.add(product.getName()),  //fold an element into a result container
                        TreeSet::addAll);  //accepts result containers and merges them






Creating a Parallel Stream is managed by parallelStream. Only speeds up for some pre-conditions.
Parallelism can bring performance benefits in certain use cases. But parallel streams cannot be 
considered as a magical performance booster. So, sequential streams should still be used as default during development.
A large amount of data and many computations done per element indicate that parallelism could be a good option.

There are Specialized Streams, for example IntStream and LongStream

The stream method iterate() takes a seed value and an unary operator and generates an infinite stream of values
 by first returning the seed, and then applying the operator to each previous element, so the stream
 will contain: seed, f(seed), f(f(seed)), etc. A second version of iterate() has a "for-loop similar usage syntax".

You can construct a stream by creating a builder and adding elements to the builder

The first version of reduce() takes a BinaryOperator to accumulate elements into a final result.
It returns an Optional. There are two more reduce versions that retures values, i.e. not Optional. 
Some example methods for reduce are add, multiply, max.

The toMap() method of the Collectors class is used to collect Streams into a Map instance.

        // Using Collectors.toMap() to compute the total price of products per category.
        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,   // Key mapper function
                        Product::getPrice,      // Value mapper function
                        BigDecimal::add));      // Merge function

Grouping Stream Elements is managed by groupingBy. The classifier function that you pass to groupingBy(key name,values def) determines how to split a stream into groups. The result is a Map where key is group name/type.

By Collectors.mapping one can transform a stream in a flexible way by a mapper and a collector. 
Mapper says what shall be extracted and collector how to "absorb" it.

Partitioning .collect(Collectors.partitioningBy(predicate)) is a special case of grouping, where the classifier function is a Predicate and the stream elements are divided into two groups.
// The result is a map with two entries, with boolean values 'true' and 'false' as keys.

DoubleStream is a stream that contains primitive double values.
 Compared to Stream<Double>, this avoids boxing and unboxing primitive double values into and out of Double wrapper objects.

        DoubleStream prices = products.stream()
                .mapToDouble(product -> product.getPrice().doubleValue());
        double total = prices.sum();  //not available on regular streams, such as sum().

The method summaryStatistics() provides statistics about the elements in the stream.
See the API documentation of the specialized streams for more methods.

        DoubleSummaryStatistics statistics = products.stream()
                .mapToDouble(product -> product.getPrice().doubleValue())
                .summaryStatistics();

        System.out.printf("Count  : %d%n", statistics.getCount());
        System.out.printf("Sum    : $ %.2f%n", statistics.getSum());
        System.out.printf("Minimum: $ %.2f%n", statistics.getMin());
        System.out.printf("Maximum: $ %.2f%n", statistics.getMax());
        System.out.printf("Average: $ %.2f%n", statistics.getAverage());


