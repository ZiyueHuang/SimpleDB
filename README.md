# SimpleDB

```
ant test
```

```
test:
    [junit] Running simpledb.CatalogTest
    [junit] Testsuite: simpledb.CatalogTest
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.03 sec
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.03 sec
    [junit] 
    [junit] Testcase: getTableId took 0.018 sec
    [junit] Testcase: getTupleDesc took 0.001 sec
    [junit] Testcase: getDatabaseFile took 0 sec
    [junit] Running simpledb.DeadlockTest
    [junit] Testsuite: simpledb.DeadlockTest
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.692 sec
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.692 sec
    [junit] ------------- Standard Output ---------------
    [junit] testReadWriteDeadlock constructing deadlock:
    [junit] testReadWriteDeadlock resolved deadlock
    [junit] testWriteWriteDeadlock constructing deadlock:
    [junit] testWriteWriteDeadlock resolved deadlock
    [junit] testUpgradeWriteDeadlock constructing deadlock:
    [junit] testUpgradeWriteDeadlock resolved deadlock
    [junit] ------------- ---------------- ---------------
    [junit] ------------- Standard Error -----------------
    [junit] DEAD LOCK: 2
    [junit] simpledb.TransactionAbortedException
    [junit] 	at simpledb.LockManager.acquireWriteLock(LockManager.java:49)
    [junit] 	at simpledb.BufferPool.getPage(BufferPool.java:62)
    [junit] 	at simpledb.TestUtil$LockGrabber.run(TestUtil.java:335)
    [junit] DEAD LOCK: 5
    [junit] simpledb.TransactionAbortedException
    [junit] 	at simpledb.LockManager.acquireWriteLock(LockManager.java:49)
    [junit] 	at simpledb.BufferPool.getPage(BufferPool.java:62)
    [junit] 	at simpledb.TestUtil$LockGrabber.run(TestUtil.java:335)
    [junit] DEAD LOCK: 8
    [junit] simpledb.TransactionAbortedException
    [junit] 	at simpledb.LockManager.acquireWriteLock(LockManager.java:49)
    [junit] 	at simpledb.BufferPool.getPage(BufferPool.java:62)
    [junit] 	at simpledb.TestUtil$LockGrabber.run(TestUtil.java:335)
    [junit] ------------- ---------------- ---------------
    [junit] 
    [junit] Testcase: testReadWriteDeadlock took 0.257 sec
    [junit] Testcase: testWriteWriteDeadlock took 0.211 sec
    [junit] Testcase: testUpgradeWriteDeadlock took 0.211 sec
    [junit] Running simpledb.FilterTest
    [junit] Testsuite: simpledb.FilterTest
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 sec
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 sec
    [junit] 
    [junit] Testcase: getTupleDesc took 0.006 sec
    [junit] Testcase: filterSomeLessThan took 0 sec
    [junit] Testcase: filterAllLessThan took 0 sec
    [junit] Testcase: filterEqual took 0.001 sec
    [junit] Testcase: filterEqualNoTuples took 0 sec
    [junit] Testcase: rewind took 0.001 sec
    [junit] Running simpledb.HeapFileReadTest
    [junit] Testsuite: simpledb.HeapFileReadTest
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.051 sec
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.051 sec
    [junit] 
    [junit] Testcase: getTupleDesc took 0.021 sec
    [junit] Testcase: numPages took 0.001 sec
    [junit] Testcase: readPage took 0.005 sec
    [junit] Testcase: testIteratorBasic took 0.003 sec
    [junit] Testcase: testIteratorClose took 0.007 sec
    [junit] Testcase: getId took 0.002 sec
    [junit] Running simpledb.HeapFileWriteTest
    [junit] Testsuite: simpledb.HeapFileWriteTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.056 sec
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.056 sec
    [junit] 
    [junit] Testcase: addTuple took 0.046 sec
    [junit] Running simpledb.HeapPageIdTest
    [junit] Testsuite: simpledb.HeapPageIdTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
    [junit] 
    [junit] Testcase: getTableId took 0.008 sec
    [junit] Testcase: pageno took 0 sec
    [junit] Testcase: testHashCode took 0 sec
    [junit] Testcase: equals took 0 sec
    [junit] Running simpledb.HeapPageReadTest
    [junit] Testsuite: simpledb.HeapPageReadTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 sec
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 sec
    [junit] 
    [junit] Testcase: getId took 0.01 sec
    [junit] Testcase: getSlot took 0.001 sec
    [junit] Testcase: getNumEmptySlots took 0 sec
    [junit] Testcase: testIterator took 0.001 sec
    [junit] Running simpledb.HeapPageWriteTest
    [junit] Testsuite: simpledb.HeapPageWriteTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.076 sec
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.076 sec
    [junit] 
    [junit] Testcase: testDirty took 0.027 sec
    [junit] Testcase: addTuple took 0.035 sec
    [junit] Testcase: deleteNonexistentTuple took 0.001 sec
    [junit] Testcase: deleteTuple took 0.001 sec
    [junit] Running simpledb.InsertTest
    [junit] Testsuite: simpledb.InsertTest
    [junit] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.038 sec
    [junit] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.038 sec
    [junit] 
    [junit] Testcase: getTupleDesc took 0.025 sec
    [junit] Testcase: getNext took 0.003 sec
    [junit] Running simpledb.IntegerAggregatorTest
    [junit] Testsuite: simpledb.IntegerAggregatorTest
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 sec
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 sec
    [junit] 
    [junit] Testcase: mergeSum took 0.01 sec
    [junit] Testcase: mergeMin took 0 sec
    [junit] Testcase: mergeMax took 0.001 sec
    [junit] Testcase: mergeAvg took 0 sec
    [junit] Testcase: testIterator took 0.001 sec
    [junit] Running simpledb.JoinPredicateTest
    [junit] Testsuite: simpledb.JoinPredicateTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 sec
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 sec
    [junit] 
    [junit] Testcase: filterVaryingVals took 0.011 sec
    [junit] Running simpledb.JoinTest
    [junit] Testsuite: simpledb.JoinTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.025 sec
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.025 sec
    [junit] 
    [junit] Testcase: eqJoin took 0.011 sec
    [junit] Testcase: gtJoin took 0.001 sec
    [junit] Testcase: getTupleDesc took 0 sec
    [junit] Testcase: rewind took 0.001 sec
    [junit] Running simpledb.LockingTest
    [junit] Testsuite: simpledb.LockingTest
    [junit] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.085 sec
    [junit] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.085 sec
    [junit] 
    [junit] Testcase: acquireReadLocksOnSamePage took 0.157 sec
    [junit] Testcase: acquireReadWriteLocksOnSamePage took 0.111 sec
    [junit] Testcase: acquireWriteReadLocksOnSamePage took 0.112 sec
    [junit] Testcase: acquireReadWriteLocksOnTwoPages took 0.11 sec
    [junit] Testcase: acquireWriteLocksOnTwoPages took 0.11 sec
    [junit] Testcase: acquireReadLocksOnTwoPages took 0.11 sec
    [junit] Testcase: lockUpgrade took 0.22 sec
    [junit] Testcase: acquireWriteAndReadLocks took 0.119 sec
    [junit] Testcase: acquireThenRelease took 0.02 sec
    [junit] Running simpledb.PredicateTest
    [junit] Testsuite: simpledb.PredicateTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 sec
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 sec
    [junit] 
    [junit] Testcase: filter took 0.011 sec
    [junit] Running simpledb.RecordIdTest
    [junit] Testsuite: simpledb.RecordIdTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
    [junit] 
    [junit] Testcase: equals took 0.007 sec
    [junit] Testcase: getPageId took 0 sec
    [junit] Testcase: tupleno took 0 sec
    [junit] Testcase: hCode took 0 sec
    [junit] Running simpledb.StringAggregatorTest
    [junit] Testsuite: simpledb.StringAggregatorTest
    [junit] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 sec
    [junit] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.022 sec
    [junit] 
    [junit] Testcase: mergeCount took 0.011 sec
    [junit] Testcase: testIterator took 0.001 sec
    [junit] Running simpledb.TransactionTest
    [junit] Testsuite: simpledb.TransactionTest
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.095 sec
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.095 sec
    [junit] 
    [junit] Testcase: commitTransaction took 0.062 sec
    [junit] Testcase: abortTransaction took 0.011 sec
    [junit] Testcase: attemptTransactionTwice took 0.011 sec
    [junit] Running simpledb.TupleDescTest
    [junit] Testsuite: simpledb.TupleDescTest
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.04 sec
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.04 sec
    [junit] 
    [junit] Testcase: nameToId took 0.024 sec
    [junit] Testcase: numFields took 0 sec
    [junit] Testcase: testEquals took 0 sec
    [junit] Testcase: combine took 0 sec
    [junit] Testcase: getType took 0.001 sec
    [junit] Testcase: getSize took 0.001 sec
    [junit] Running simpledb.TupleTest
    [junit] Testsuite: simpledb.TupleTest
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
    [junit] 
    [junit] Testcase: getTupleDesc took 0.008 sec
    [junit] Testcase: modifyRecordId took 0.001 sec
    [junit] Testcase: modifyFields took 0 sec

BUILD SUCCESSFUL
Total time: 7 seconds
```

```
ant systemtest
```

```
systemtest:
    [junit] Running simpledb.systemtest.AbortEvictionTest
    [junit] Testsuite: simpledb.systemtest.AbortEvictionTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.094 sec
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.094 sec
    [junit] 
    [junit] Testcase: testDoNotEvictDirtyPages took 0.084 sec
    [junit] Running simpledb.systemtest.DeleteTest
    [junit] Testsuite: simpledb.systemtest.DeleteTest
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.172 sec
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.172 sec
    [junit] 
    [junit] Testcase: testEquals took 0.075 sec
    [junit] Testcase: testLessThan took 0.024 sec
    [junit] Testcase: testLessThanOrEq took 0.021 sec
    [junit] Testcase: testGreaterThan took 0.02 sec
    [junit] Testcase: testGreaterThanOrEq took 0.017 sec
    [junit] Running simpledb.systemtest.EvictionTest
    [junit] Testsuite: simpledb.systemtest.EvictionTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.916 sec
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.916 sec
    [junit] ------------- Standard Output ---------------
    [junit] EvictionTest creating large table
    [junit] EvictionTest scanning large table
    [junit] EvictionTest scan complete, testing memory usage of scan
    [junit] ------------- ---------------- ---------------
    [junit] 
    [junit] Testcase: testHeapFileScanWithManyPages took 0.907 sec
    [junit] Running simpledb.systemtest.FilterTest
    [junit] Testsuite: simpledb.systemtest.FilterTest
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.113 sec
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.113 sec
    [junit] 
    [junit] Testcase: testEquals took 0.05 sec
    [junit] Testcase: testLessThan took 0.016 sec
    [junit] Testcase: testLessThanOrEq took 0.013 sec
    [junit] Testcase: testGreaterThan took 0.011 sec
    [junit] Testcase: testGreaterThanOrEq took 0.011 sec
    [junit] Running simpledb.systemtest.InsertTest
    [junit] Testsuite: simpledb.systemtest.InsertTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.058 sec
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.058 sec
    [junit] 
    [junit] Testcase: testEmptyToOne took 0.03 sec
    [junit] Testcase: testOneToEmpty took 0.008 sec
    [junit] Testcase: testOneToOne took 0.006 sec
    [junit] Testcase: testEmptyToEmpty took 0.002 sec
    [junit] Running simpledb.systemtest.JoinTest
    [junit] Testsuite: simpledb.systemtest.JoinTest
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.048 sec
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.048 sec
    [junit] 
    [junit] Testcase: testSingleMatch took 0.029 sec
    [junit] Testcase: testNoMatch took 0.004 sec
    [junit] Testcase: testMultipleMatch took 0.004 sec
    [junit] Running simpledb.systemtest.LogTest
    [junit] Testsuite: simpledb.systemtest.LogTest
    [junit] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.164 sec
    [junit] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.164 sec
    [junit] 
    [junit] Testcase: TestOpenCommitOpenCrash took 0.051 sec
    [junit] Testcase: TestOpenCommitCheckpointOpenCrash took 0.025 sec
    [junit] Testcase: PatchTest took 0.006 sec
    [junit] Testcase: TestFlushAll took 0.007 sec
    [junit] Testcase: TestCommitCrash took 0.005 sec
    [junit] Testcase: TestAbort took 0.007 sec
    [junit] Testcase: TestAbortCommitInterleaved took 0.019 sec
    [junit] Testcase: TestAbortCrash took 0.008 sec
    [junit] Testcase: TestCommitAbortCommitCrash took 0.013 sec
    [junit] Testcase: TestOpenCrash took 0.007 sec
    [junit] Running simpledb.systemtest.ScanTest
    [junit] Testsuite: simpledb.systemtest.ScanTest
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.418 sec
    [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.418 sec
    [junit] 
    [junit] Testcase: testSmall took 0.24 sec
    [junit] Testcase: testRewind took 0.003 sec
    [junit] Testcase: testCache took 0.164 sec
    [junit] Running simpledb.systemtest.TransactionTest
    [junit] Testsuite: simpledb.systemtest.TransactionTest
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.194 sec
    [junit] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.194 sec
    [junit] ------------- Standard Error -----------------
    [junit] DEAD LOCK: 3
    [junit] DEAD LOCK: 4
    [junit] DEAD LOCK: 0
    [junit] DEAD LOCK: 2
    [junit] DEAD LOCK: 8
    [junit] DEAD LOCK: 6
    [junit] DEAD LOCK: 7
    [junit] DEAD LOCK: 10
    [junit] DEAD LOCK: 11
    [junit] DEAD LOCK: 12
    [junit] DEAD LOCK: 21
    [junit] DEAD LOCK: 16
    [junit] DEAD LOCK: 22
    [junit] DEAD LOCK: 23
    [junit] DEAD LOCK: 25
    [junit] DEAD LOCK: 17
    [junit] DEAD LOCK: 19
    [junit] DEAD LOCK: 20
    [junit] DEAD LOCK: 24
    [junit] DEAD LOCK: 26
    [junit] DEAD LOCK: 34
    [junit] DEAD LOCK: 27
    [junit] DEAD LOCK: 28
    [junit] DEAD LOCK: 30
    [junit] DEAD LOCK: 32
    [junit] DEAD LOCK: 29
    [junit] DEAD LOCK: 33
    [junit] DEAD LOCK: 40
    [junit] DEAD LOCK: 42
    [junit] DEAD LOCK: 41
    [junit] DEAD LOCK: 37
    [junit] DEAD LOCK: 36
    [junit] DEAD LOCK: 39
    [junit] DEAD LOCK: 38
    [junit] DEAD LOCK: 48
    [junit] DEAD LOCK: 49
    [junit] DEAD LOCK: 47
    [junit] DEAD LOCK: 46
    [junit] DEAD LOCK: 45
    [junit] DEAD LOCK: 44
    [junit] DEAD LOCK: 55
    [junit] DEAD LOCK: 51
    [junit] DEAD LOCK: 52
    [junit] DEAD LOCK: 53
    [junit] DEAD LOCK: 54
    [junit] DEAD LOCK: 60
    [junit] DEAD LOCK: 59
    [junit] DEAD LOCK: 57
    [junit] DEAD LOCK: 58
    [junit] DEAD LOCK: 64
    [junit] DEAD LOCK: 62
    [junit] DEAD LOCK: 63
    [junit] DEAD LOCK: 67
    [junit] DEAD LOCK: 66
    [junit] DEAD LOCK: 68
    [junit] DEAD LOCK: 76
    [junit] ------------- ---------------- ---------------
    [junit] 
    [junit] Testcase: testFiveThreads took 0.065 sec
    [junit] Testcase: testTenThreads took 0.068 sec
    [junit] Testcase: testAllDirtyFails took 0.035 sec
    [junit] Testcase: testSingleThread took 0.005 sec
    [junit] Testcase: testTwoThreads took 0.009 sec

BUILD SUCCESSFUL
Total time: 4 seconds
```
