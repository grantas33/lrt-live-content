# Stage 1 - the build process
FROM node as build-deps
COPY package.json yarn.lock ./
RUN yarn 
COPY . ./
RUN yarn build

# Stage 2 - the production environment
FROM nginx:1.12-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build-deps ./build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]