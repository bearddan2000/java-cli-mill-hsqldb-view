FROM nightscape/scala-mill

WORKDIR /tmp

COPY bin/ .

ENTRYPOINT ["mill"]

CMD ["CLI"]
