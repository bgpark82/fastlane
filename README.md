# 패스트레인 사전과제

## Summary
사용자 관리 프로그램

## Install
```
./gradlew build
java -jar ./build/service-0.0.1-SNAPSHOT.jar
```

## Test
```
./gradlew test
```

## Convention
- class : Pascal case
- variable : Camel case
- package : Kebab case

## Directory Structure
```
src
├── main
│   └── domain
│       └── user
│           ├── application
│           ├── domain
│           ├── dto
│           └── ui
└── test
    └── domain
        └── user
            ├── acceptance
            ├── application
            ├── domain
            ├── step
            └── ui
```
