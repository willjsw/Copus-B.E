# 고전한문코퍼스 (Copus-B.E)

성균관대학교 고전한문코퍼스 프로젝트는 한국 및 동아시아 고전 문헌의 전산화 및 연구를 지원하기 위한 백엔드 시스템입니다. 이 프로젝트는 XML 형식의 원문 데이터를 통합하고 관리할 수 있는 데이터베이스를 구축하며, 연구자들이 손쉽게 데이터를 조회하고 활용할 수 있도록 API를 제공합니다.

## 📌 프로젝트 개요
- **프로젝트명:** 고전한문코퍼스 백엔드 (Copus-B.E)
- **목적:** 고전 한문 자료의 전산화 및 연구 지원을 위한 백엔드 시스템 구축
- **주요 기능:** XML 데이터 관리, 검색 기능, API 제공

## 🔧 기술 스택
- **프레임워크:** Spring Boot
- **빌드 도구:** Gradle
- **데이터베이스:** MariaDB
- **배포:** Docker

## 📂 프로젝트 구조
Copus-B.E/ ├── src/ │ ├── main/ │ │ ├── java/ # Java 소스 코드 │ │ └── resources/ # 설정 파일 및 리소스 │ └── test/ # 테스트 코드 ├── .github/ │ └── ISSUE_TEMPLATE/ # 이슈 템플릿 ├── .gitignore # Git 무시 파일 목록 ├── build.gradle # Gradle 빌드 스크립트 ├── Dockerfile # Docker 설정 파일 ├── gradlew # Gradle Wrapper 실행 파일 (Unix) ├── gradlew.bat # Gradle Wrapper 실행 파일 (Windows) └── settings.gradle # Gradle 설정 파일
