# 1. Overview [![Code coverage](https://coveralls.io/repos/manish-in-java/spring-data-jta/badge.svg?branch=master&service=github)](https://coveralls.io/github/manish-in-java/spring-data-jta?branch=master)
This sample application demonstrates the use of an external [JTA](http://en.wikipedia.org/wiki/Java_Transaction_API)
transaction manager in a Spring Data JPA application.  It uses two database schemas,
saving data to and reading from these schemas, as needed to demonstrate and test the
use of JTA transactions.

The steps below outline how the JTA transaction manager is configured:

1. One or more XA-compliant data source that will manage the underlying data store.
Most libraries provide XA-compliant versions of their drivers.  For example, the class
`org.h2.Driver` is the regular (non-XA) JDBC driver for the H2 in-memory database.
The XA-compliant data source for the same database is provided by the class
`org.h2.jdbcx.JdbcDataSource`.  Similarly, where `com.mysql.jdbc.Driver` is the regular
JDBC driver class for the MySQL database, `com.mysql.jdbc.jdbc2.optional.MysqlXADataSource`
provides the XA-compliant data source.
1. Wrap the XA data source in a JTA-enabled `DataSource`.  This class is responsible
for ensuring that the wrapped XA data source participates in JTA transactions.
1. Point the `EntityManagerFactory` instance to the `DataSource` instance.
This makes sure that the database connections participate in JTA transactions.
1. Declare an XA transaction manager and an XA user transaction.
1. Wrap the XA transaction manager in a Spring `JtaTransactionManager`.
1. Use the Spring `JtaTransactionManager`.

In order to see everything in action, install JDK8+ and Maven 3.1+ and run
`mvn clean test` to run the tests included with the app.

# 2. JTA providers

## 2.1. Atomikos Transaction Essentials

[Atomikos TransactionEssentials](http://www.atomikos.com/Main/TransactionsEssentials) is
a JTA transaction manager that comes in both open-source and commercial flavours. The
open-source version of Atomikos is included with this application. To see Atomikos in action,
run the bundled integration test as `mvn clean test -D"spring.profiles.active=atomikos"`.

The open-source version of Atomikos used for this application is available under the
Apache License v2.0. Full licensing details are available on the
[Atomikos website](https://www.atomikos.com/Main/WhichLicenseApplies).

## 2.2. Bitronix Transaction Manager

[Bitronix Transaction Manager](https://github.com/bitronix/btm) is a fully open-source
JTA transaction manager. Run the bundled integration tests as
`mvn clean test -D"spring.profiles.active=bitronix"` to see Bitronix in action.

The Bitronix version used for this application is available under the
GNU Lesser General Public License v3.0. Full licensing details are available
on Bitronix's [Github repository](https://github.com/bitronix/btm).

## 2.3. JBoss Transaction Server

*JBoss Transaction Server (JBossTS)* was an open-source JTA transaction manager that
used to ship as part of the [JBoss J2EE Application Server](http://jbossas.jboss.org).

The JBossTS version used for this application is available under the
GNU Lesser General Public License v2.1.

# 3. License
This sample application and its associated source code in its entirety is being made
available under the following licensing terms.

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
