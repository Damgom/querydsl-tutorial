# QueryDSL

## QueryDSL을 사용하는 이유
> JPA 가 기본적으로 제공해주는 CRUD 메서드 및 쿼리 메서드 기능을 사용하는 것 이외에도 원하는 조건의 데이터를 가져오기 위해서 네이티브 쿼리를 작성해야 하는데,
> 간단한 쿼리를 작성하는데는 문제가 없다. 하지만 복잡한 쿼리를 작성할 때(개행이 포함되는 긴 쿼리) 오류가 발생하기 쉽다.
> 이런 네이티브쿼리를 작성해서 사용하는 경우 쿼리문에서 문법적인 오류가 있는 경우 런타임 시점에서 에러가 발생하게 된다.
> 
> 하지만 QueryDSL 을 사용해 정적타입의 쿼리를 생성해 사용한다면 Application 로딩 시점에 오류를 발견할 수 있다.

- 문자가 아닌 코드로 쿼리를 작성하기 때문에 컴파일 시점에 문법 오류를 쉽게 확인할 수 있다.
- IDE 의 도움을 받을 수 있다.
- 동적 쿼리 작성이 편리하다.
- 쿼리 작성 시 제약 조건 등을 메서드 추출을 통해 재사용할 수 있다.

<details>
<summary>gradle 설정</summary>
<div markdown="1">
  <pre> 
// 1. queryDsl version 정보 추가
buildscript {
	ext {
		queryDslVersion = "5.0.0"
	}
}
// 2. querydsl plugins 추가
plugins {
	id "com.ewerk.gradle.plugins.querydsl" version "1.0.10"
}
//QueryDSL dependencies 추가
	implementation "com.querydsl:querydsl-jpa:${queryDslVersion}"
	implementation "com.querydsl:querydsl-apt:${queryDslVersion}"

/*
 * queryDSL 설정 추가
 */
// querydsl에서 사용할 경로 설정
def querydslDir = "$buildDir/generated/querydsl"
// JPA 사용 여부와 사용할 경로를 설정
querydsl {
	jpa = true
	querydslSourcesDir = querydslDir
}
// build 시 사용할 sourceSet 추가
sourceSets {
	main.java.srcDir querydslDir
}
// querydsl 컴파일시 사용할 옵션 설정
compileQuerydsl{
	options.annotationProcessorPath = configurations.querydsl
}
// querydsl 이 compileClassPath 를 상속하도록 설정
configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
	querydsl.extendsFrom compileClasspath
}
</pre>
  </div>
</details>