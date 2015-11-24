# scala-benchmark

## abstract

This repository is various benchmark project using Scala.

## dependencies

* sbt
* sbt-jmt

## How to run?

```
sbt
[info] Loading project definition from ...
[info] Set current project to com.inkenkun.x1.scala.benchmark ...
>
# compile classes
> jmh:compile

# run all benchmark
#   measurement: 2, worming-up number: 3, total number: 1, threads: 2, mode: all
jmh:run -i 2 -wi 3 -f 1 -t 2 -bm all

# run specific class benchmark
#   measurement: 2, worming-up number: 3, total number: 1, threads: 2, mode: Throughput
jmh:run com.inkenkun.x1.scala.benchmark.Cfibonacci.+ -i 2 -wi 3 -f 1 -t 2 -bm thrpt

# run specific method benchmark
#   measurement: 2, worming-up number: 3, total number: 1, threads: 2, mode: AverageTime
jmh:run com.inkenkun.x1.scala.benchmark.Cfibonacci.stream10000 -i 2 -wi 3 -f 1 -t 2 -bm avgt
```

## trouble shooting

* if OutOfMemory occured

run sbt with `-mem` option

```
SBT_OPTS="-Xss1m" sbt -mem 4098
```