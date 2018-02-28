FROM mongo:3
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD init.sh /init.sh
ADD ./dump /

RUN \
 chmod +x /init.sh 
# && \
# yum install psmisc -y 
# delete cache

ENTRYPOINT ["/init.sh"]