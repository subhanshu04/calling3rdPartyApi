package com.example.productservicescaler.inheritanceExamples.singleTable;

import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleUserRepo extends JpaRepository<User,Long> {
}
