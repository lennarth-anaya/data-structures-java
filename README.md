
# data-structures-java

Data structures examples in Java

# Setup

Make sure you have a folder where dependencies are downloaded only once. This is worth even for other Java projects.

```
mkdir ../maven-repo
```

# Build

```
sudo docker run \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw clean install
```

# Run Tests

Rather than having a standalone application showcasing how these data structureswork, several planned Unit tests are given to demonstrate they work as expected, so you would have to understand such test cases since their execution just will give you a successful or failure response status.


```
sudo docker run \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw exec:java -Dexec.mainClass="com.example.bank.App"
```

## Run all unit tests

```
sudo docker run \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw test
```

## Run all tests in specific test classes

Pass the name or comma separated names of classes to test java env param. Example:

```
sudo docker run \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw -Dtest=BSTreeTraversersTest,AvlTreeRotationsTest test
```


## Run an specific test method
```
sudo docker run \
    -v "$PWD":/project -w /project \
    -v "$PWD/../maven-repo":/root/.m2 \
    openjdk ./mvnw -Dtest=BSTreeTraversersTest#byLevelTraverse test
```


