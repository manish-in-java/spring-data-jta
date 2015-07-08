# Overview [![Build status](https://drone.io/github.com/manish-in-java/spring-data-jta/status.png)](https://drone.io/github.com/manish-in-java/spring-data-jta/latest) [![Code coverage](https://coveralls.io/repos/manish-in-java/spring-data-jta/badge.svg?branch=master&service=github)](https://coveralls.io/github/manish-in-java/spring-data-jta?branch=master)
This sample application demonstrates the use of an external [JTA](http://en.wikipedia.org/wiki/Java_Transaction_API)
transaction manager in a Spring Data JPA application.  It uses two database schemas,
saving data to and reading from these schemas, as needed to demonstrate and test the
use of JTA transactions.

This application uses [Atomikos TransactionEssentials](http://www.atomikos.com/Main/TransactionsEssentials),
an open-source JTA transaction manager.  A development version of the transaction manager
library has been used because the current production version (3.9.3) does not work with
Hibernate 4, the JPA provider used in the application.

The steps below outline how the JTA transaction manager is configured:

1. One or more XA-compliant data source that will manage the underlying data store.
Most libraries provide XA-compliant versions of their drivers.  For example, the class
`org.h2.Driver` is the regular (non-XA) JDBC driver for the H2 in-memory database.
The XA-compliant data source for the same database is provided by the class
`org.h2.jdbcx.JdbcDataSource`.  Similarly, where `com.mysql.jdbc.Driver` is the regular
JDBC driver class for the MySQL database, `com.mysql.jdbc.jdbc2.optional.MysqlXADataSource`
provides the XA-compliant data source.
1. Wrap the XA data source in an `AtomikosDataSourceBean`.  This class is responsible
for ensuring that the wrapped XA data source participates in JTA transactions.
1. Point the `EntityManagerFactory` instance to the `AtomikosDataSourceBean` instance.
This makes sure that the database connections participate in JTA transactions.
1. Declare an XA transaction manager and an XA user transaction.
1. Wrap the XA transaction manager in a Spring `JtaTransactionManager`.
1. Use the Spring `JtaTransactionManager`.

# License
This sample application and its associated source code in its entirety is being made
available under the following licensing terms.

    Copyright (C) 2014

    Permission is hereby granted, free of charge, to any person obtaining a copy of
    this software and associated documentation files (the "Software"), to deal in the
    Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
    and to permit persons to whom the Software is furnished to do so, subject to the
    following conditions:

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
    PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
    HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
    CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
    OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
