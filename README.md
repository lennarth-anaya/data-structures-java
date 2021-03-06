
# data-structures-java

Data structures examples in Java. THey are coded in a way that it maximizes the principle of separations of concerns so students can understand every operation in a neatr way than when having all the operations in a single structure java class. The principle of encapsulation dictates we should use a facade to operate all those operations in a coherent unbreakable way. For instance, the use of such facade will guarantee an AVL Tree is not broken by using non-avl operations.

# Setup

Make sure you have a folder where dependencies are downloaded only once. This is worth even for other Java projects.

```
git clone https://github.com/lennarth-anaya/data-structures-java.git
cd data-structures-java
mkdir ../maven-repo
```

# Build

```
sudo docker run \
    --rm \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw clean install
```

# Run Tests

Rather than having a standalone application showcasing how these data structureswork, several planned Unit tests are given to demonstrate they work as expected, so you would have to understand such test cases since their execution just will give you a successful or failure response status.```

## Run all unit tests

```
sudo docker run \
    --rm \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw test
```

## Run all tests in specific test classes

Pass the name or comma separated names of classes to test java env param. Example:

```
sudo docker run \
    --rm \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw -Dtest=BSTreeTraversersTest,AvlTreeRotationsTest test
```


## Run an specific test method
```
sudo docker run \
    --rm \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw -Dtest=BSTreeTraversersTest#byLevelTraverse test
```


