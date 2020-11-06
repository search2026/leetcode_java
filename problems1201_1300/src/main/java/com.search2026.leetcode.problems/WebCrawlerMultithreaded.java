package com.search2026.leetcode.problems;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class WebCrawlerMultithreaded {

    /*
        Web Crawler Multithreaded
        Leetcode #1242
        https://github.com/search2026/leetcode_java/blob/master/problems1201_1300/resources/WebCrawlerMultithreaded.md
        Difficulty: Medium
     */
    class CrawlWorker implements Runnable {

        private String startUrl;

        private CountDownLatch countDownLatch;

        private HtmlParser htmlParser;

        CrawlWorker(String startUrl, CountDownLatch countDownLatch, HtmlParser htmlParser) {
            this.startUrl = startUrl;
            this.countDownLatch = countDownLatch;
            this.htmlParser = htmlParser;
        }

        @Override
        public void run() {
            parse();
        }

        private void parse() {
            urlSet.add(startUrl);
            List<String> urlList = htmlParser.getUrls(startUrl);
            for (String url : urlList) {
                if (urlSet.contains(url) || !getHost(url).equals(hostName)) {
                    continue;
                }
                queue.offer(url);
            }

            this.countDownLatch.countDown();
        }
    }

    private final Set<String> urlSet = ConcurrentHashMap.newKeySet();
    private final Queue<String> queue = new ConcurrentLinkedQueue<>();

    private String hostName;
    private static final Integer MAX_ALIVE_THREAD_NUM = 128;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        hostName = getHost(startUrl);

        queue.offer(startUrl);
        while (!queue.isEmpty()) {

            int curThreadNum = Math.min(MAX_ALIVE_THREAD_NUM, queue.size());

            CountDownLatch countDownLatch = new CountDownLatch(curThreadNum);

            for (int idx = 0; idx < curThreadNum; idx++) {
                String curUrl = queue.poll();
                CrawlWorker crawlWorker = new CrawlWorker(curUrl, countDownLatch, htmlParser);
                Thread thread = new Thread(crawlWorker);
                thread.start();
            }

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(urlSet);
    }


    private static String getHost(String url) {
        String host = url.substring(7); // all urls use http protocol
        int idx = host.indexOf('/');
        if (idx == -1) {
            return host;
        }
        return host.substring(0, idx);
    }

    public class HtmlParser {
        HtmlParser() {
        }

        public List<String> getUrls(String url) {
            List<String> res = new LinkedList<>();
            return res;
        }
    }

}
