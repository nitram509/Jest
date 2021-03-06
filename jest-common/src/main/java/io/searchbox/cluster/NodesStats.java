package io.searchbox.cluster;

import io.searchbox.action.AbstractMultiINodeActionBuilder;
import io.searchbox.action.GenericResultAbstractAction;

/**
 * @author Dogukan Sonmez
 * @author cihat keser
 */
public class NodesStats extends GenericResultAbstractAction {

    protected NodesStats(Builder builder) {
        super(builder);
        setPathToResult("nodes");
        setURI(buildURI());
    }

    @Override
    protected String buildURI() {
        StringBuilder sb = new StringBuilder(super.buildURI());
        sb.append("/_nodes/")
                .append(nodes)
                .append("/stats");
        return sb.toString();
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends AbstractMultiINodeActionBuilder<NodesStats, Builder> {

        public Builder withSettings() {
            return addCleanApiParameter("settings");
        }

        /**
         * Indices stats about size, document count, indexing and deletion times, search times, field cache size , merges and flushes
         */
        public Builder withIndices() {
            return addCleanApiParameter("indices");
        }

        /**
         * File system information, data path, free disk space, read/write stats
         */
        public Builder withFs() {
            return addCleanApiParameter("fs");
        }

        /**
         * HTTP connection information
         */
        public Builder withHttp() {
            return addCleanApiParameter("http");
        }

        /**
         * JVM stats, memory pool information, garbage collection, buffer pools
         */
        public Builder withJvm() {
            return addCleanApiParameter("jvm");
        }

        /**
         * TCP information
         */
        public Builder withNetwork() {
            return addCleanApiParameter("network");
        }

        /**
         * Operating system stats, load average, cpu, mem, swap
         */
        public Builder withOs() {
            return addCleanApiParameter("os");
        }

        /**
         * Process statistics, memory consumption, cpu usage, open file descriptors
         */
        public Builder withProcess() {
            return addCleanApiParameter("process");
        }

        /**
         * Statistics about each thread pool, including current size, queue and rejected tasks
         */
        public Builder withThreadPool() {
            return addCleanApiParameter("thread_pool");
        }

        /**
         * Transport statistics about sent and received bytes in cluster communication
         */
        public Builder withTransport() {
            return addCleanApiParameter("transport");
        }

        /**
         * Clears all the flags (first). Useful, if you only want to retrieve specific stats
         */
        public Builder withClear() {
            return addCleanApiParameter("clear");
        }

        @Override
        public NodesStats build() {
            return new NodesStats(this);
        }
    }
}

