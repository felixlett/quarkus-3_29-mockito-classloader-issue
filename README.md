Code is modified based on the Quarkus guide for Quarkus 3.28: https://quarkus.io/guides/getting-started-testing

This repo aims to be a minimal reproduction of a classloader issue when using Quarkus 3.29+ with Mockito for mocking Java Exceptions.
It seems that the exception class is cached after calling the first test and then the cached item is used for the second test.
However the classloaders of these Exception classes are incompatible causing equality tests to fail.

Run the tests using `mvn verify`. They pass in Quarkus 3.28 yet fail starting from Quarkus 3.29+.