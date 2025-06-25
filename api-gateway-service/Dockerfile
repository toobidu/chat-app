# Sử dụng image JDK 23 chính thức từ Eclipse Temurin
FROM eclipse-temurin:23-jdk-alpine

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file JAR vào container (bạn cần build trước bằng Maven)
COPY target/api-gateway-*.jar app.jar

# Khởi động ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
