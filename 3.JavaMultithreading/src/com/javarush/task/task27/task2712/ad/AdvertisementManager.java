package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Victor on 10.11.2017.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    /*public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> advertisements = storage.list();
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> bestAdvertisements = new AdvertisementHelper().findBestAdvertisements();


    }

    private class AdvertisementHelper {
        private int bestPrice;
        private int maxTime;
        private int videosCount;
        private List<Advertisement> bestAdvertisements = new ArrayList<>();
        private List<Advertisement> advertisementsToChoice = new ArrayList<>();

        public List<Advertisement> findBestAdvertisements() {
            for (Advertisement advertisement : storage.list()) {
                if (advertisement.getDuration() < timeSeconds && advertisement.getHits() > 0) {
                    advertisementsToChoice.add(advertisement);
                }
            }
            if (advertisementsToChoice.isEmpty()) {
                throw new NoVideoAvailableException();
            } else {
                bestAdvertisementsGetting(new BinaryPattern(advertisementsToChoice.size()));
            }

            return bestAdvertisements;
        }

        private void bestAdvertisementsGetting(BinaryPattern binaryPattern) {
            while (true) {
                checkAdvertisements(binaryPattern.getPattern());
                if (!binaryPattern.full()) {
                    binaryPattern.increment();
                } else {
                    break;
                }
                bestAdvertisementsGetting(binaryPattern);
            }

        }

        private void checkAdvertisements(int[] pattern) {
            int price = 0;
            int time = 0;
            List<Advertisement> list = new ArrayList<>();
            for (int i = 0; i < advertisementsToChoice.size(); i++) {
                price += advertisementsToChoice.get(i).getAmountPerOneDisplaying() * pattern[i];
                time += advertisementsToChoice.get(i).getDuration() * pattern[i];
                if (pattern[i] == 1){
                    list.add(advertisementsToChoice.get(i));
                }
            }
            if (time > timeSeconds){
                return;
            }
            if (!(price > bestPrice)){
                if (!(price == bestPrice && time > maxTime)){
                    if (!(price == bestPrice && time == maxTime && list.size() < videosCount)){
                        return;
                    }
                }
            }
            bestAdvertisements = list;
            bestPrice = price;
            maxTime = time;
            videosCount = list.size();

        }


        private class BinaryPattern {
            private int size;
            private int count;

            public BinaryPattern(int size) {
                this.size = size;
                this.count = 0;
            }

            public int[] getPattern() {
                String regString = Integer.toBinaryString(count);
                int difference = size - regString.length();
                int[] pattern = new int[size];
                for (int i = difference; i < pattern.length; i++) {
                    if (regString.charAt(i - difference) == '1') {
                        pattern[i] = 1;
                    } else {
                        pattern[i] = 0;
                    }
                }
                return pattern;
            }

            public void increment() {
                count++;
            }


            public boolean full() {
                return count == (int) Math.pow(2, size) - 1;
            }
        }
    }*/
//https://gist.github.com/neustupov/402fa19de34a335950058e8171231c57
    /*public void processVideos() throws NoVideoAvailableException {

        List<Advertisement> videos = storage.list();
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();

        // ищем список видео для показа согласно критериям
        List<Advertisement> bestAds = new VideoHelper().findAllYouNeed();

        // сортируем полученный список
        Collections.sort(bestAds, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement video1, Advertisement video2) {
                long dif = video2.getAmountPerOneDisplaying() - video1.getAmountPerOneDisplaying();
                if (dif == 0) dif = video2.getDuration() - video1.getDuration();
                return (int) dif;
            }
        });
        long amount = 0;
        int totalDuration = 0;
        for (Advertisement ad : bestAds) {
            totalDuration += ad.getDuration();
            amount += ad.getAmountPerOneDisplaying();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestAds, amount, totalDuration));


        // выводим список
        for (Advertisement ad : bestAds) {
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " +
                    ad.getAmountPerOneDisplaying() + ", " +
                    1000 * ad.getAmountPerOneDisplaying() / ad.getDuration());
            ad.revalidate();
        }
    }

    private class VideoHelper {
        private int bestPrice = 0;
        private int maxTime = 0;
        private int numberOfClips = 0;
        private List<Advertisement> bestAds = new ArrayList<>();
        private List<Advertisement> candidates = new ArrayList<>();

        public List<Advertisement> findAllYouNeed() {
            // отбор кандидатов
            for (Advertisement ad : storage.list()) {
                if (ad.getDuration() <= timeSeconds && ad.getHits() > 0)
                    candidates.add(ad);
            }
            if (candidates.isEmpty()) {
                throw new NoVideoAvailableException();
            } else findBestAds(new BinaryPattern(candidates.size()));
            return bestAds;
        }

        // рекурсивная функция формирования списка для показа
        public void findBestAds(BinaryPattern pattern) {
            while (true) {
                checkAds(pattern.getPattern());
                if (!pattern.full()) pattern.increment();
                else break;
                findBestAds(pattern);
            }
        }

        // проверка очередного набора видеоклипов
        private void checkAds(int[] pattern) {
            int price = 0;
            int time = 0;
            List<Advertisement> list = new ArrayList<>();
            for (int i = 0; i < candidates.size(); i++) {
                price += candidates.get(i).getAmountPerOneDisplaying() * pattern[i];
                time += candidates.get(i).getDuration() * pattern[i];
                if (pattern[i] == 1) list.add(candidates.get(i));
            }
            if (time > timeSeconds) return;
            if (!(price > bestPrice)) {
                if (!(price == bestPrice && time > maxTime)) {
                    if (!(price == bestPrice && time == maxTime && list.size() < numberOfClips)) {
                        return;
                    }
                }
            }
            bestAds = list;
            bestPrice = price;
            maxTime = time;
            numberOfClips = list.size();
        }

        // формирование двоичных масок для сбора списка видеоклипов
        private class BinaryPattern {
            private int length;
            private int count;

            public BinaryPattern(int size) {
                this.length = size;
                this.count = 0;
            }

            public int[] getPattern() {
                String regString = Integer.toBinaryString(count);
                int dif = length - regString.length();
                int[] pattern = new int[length];
                for (int j = dif; j < pattern.length; j++) {
                    if (regString.charAt(j - dif) == '1') pattern[j] = 1;
                    else pattern[j] = 0;
                }
                return pattern;
            }

            public void increment() {
                count++;
            }

            public boolean full() {
                return count == (int) Math.pow(2, length) - 1;
            }
        }
    }*/
    //https://gist.github.com/FaAway/76abc7c861b26c79843b
    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> candidates = new ArrayList<>();
        //Include only compatible by duration video
        for (Advertisement ad: storage.list()) {
            if (ad.getDuration() <= timeSeconds && ad.getHits() > 0)
                candidates.add(ad);
        }

        //If no one compatible
        if (candidates.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        //Select optimal video set by exhaustive search
        OptimalVideoSet optimalVideoSet = new OptimalVideoSet(candidates, timeSeconds);
        List<Advertisement> optimalVideoList = optimalVideoSet.getOptimalVideoSet();
        //Sort video playlist
        Collections.sort(optimalVideoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()
                        ? (o1.getAmountPerSecond() - o2.getAmountPerSecond()) * 1000000
                        : o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

        //Register event before showing videos
        StatisticManager.getInstance().register(
                new VideoSelectedEventDataRow(
                        optimalVideoList,
                        optimalVideoSet.getOptimalVideoSetAmount(),
                        optimalVideoSet.getOptimalVideoSetDuration()
                )
        );

        //Show videos & update ads' data
        for (int i = 0; i < optimalVideoList.size(); i++) {
            Advertisement showingAd = optimalVideoList.get(i);
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    showingAd.getName(),
                    showingAd.getAmountPerOneDisplaying(),
                    (int)(showingAd.getAmountPerSecond() * 1000)
            ));
            showingAd.revalidate();

        }
    }

    private class OptimalVideoSet  {
        private int toShowTimeSeconds;
        private CopyOnWriteArrayList<Advertisement> candidates_ = new CopyOnWriteArrayList<>();

        private int optimalVideoSetAmount = 0;
        private int optimalVideoSetTime = 0;
        private CopyOnWriteArrayList<Advertisement> optimalVideoSet;


        public OptimalVideoSet(List<Advertisement> candidates, int toShowTimeSeconds) {
            this.toShowTimeSeconds = toShowTimeSeconds;
            this.candidates_.addAll(candidates);
        }

        public List<Advertisement> getOptimalVideoSet() {
            Sortout(candidates_);
            List<Advertisement> result = new ArrayList<>();
            result.addAll(optimalVideoSet);
            return result;
        }

        //exhaustive search
        private void Sortout(CopyOnWriteArrayList<Advertisement> candidates) {
            CopyOnWriteArrayList<Advertisement> currentList = candidates;
            //Calculate current video set parameters
            int amountOfAd = 0;
            int sumOfAdTime = 0;
            for (Advertisement ad : currentList) {
                amountOfAd += ad.getAmountPerOneDisplaying();
                sumOfAdTime += ad.getDuration();
            }
            //If video set is too long eliminate each video
            // & invoke optimal set finding in recursion sequentially
            if (sumOfAdTime > toShowTimeSeconds)
                for (int i = currentList.size() - 1; i >= 0; i--) {
                    candidates = (CopyOnWriteArrayList<Advertisement>) currentList.clone();
                    candidates.remove(i);
                    Sortout(candidates);
                }
            else {
                //Replace optimal result if current set is better
                if (amountOfAd > optimalVideoSetAmount) {
                    optimalVideoSet = currentList;
                } else if (amountOfAd == optimalVideoSetAmount)
                    if (sumOfAdTime > optimalVideoSetTime)
                        optimalVideoSet = currentList;
                    else if (sumOfAdTime == optimalVideoSetTime)
                        if (currentList.size() < optimalVideoSet.size())
                            optimalVideoSet = currentList;
                if (optimalVideoSet == currentList) {
                    optimalVideoSetAmount = amountOfAd;
                    optimalVideoSetTime = sumOfAdTime;
                }
            }
        }

        public int getOptimalVideoSetDuration() {
            return optimalVideoSetTime;
        }

        public int getOptimalVideoSetAmount() {
            return optimalVideoSetAmount;
        }
    }
}
