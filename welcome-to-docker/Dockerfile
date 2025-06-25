# ✅ Node.js base image
FROM node:20-alpine

# 📁 App directory
WORKDIR /app

# 📦 Copy dependencies
COPY package*.json ./

# 📁 Copy source
COPY ./src ./src
COPY ./public ./public

# 📦 Install & buil
RUN npm install \
    && npm install -g serve \
    && npm run build \
    && rm -fr node_modules

# 🌐 Expose port
EXPOSE 8068

# 🚀 Serve the app
CMD ["serve", "-s", "build", "-l", "8068"]
