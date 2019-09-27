select * from Movimentacao where DataOcorrencia"
                + (untilNow ? " <= NOW()" 
                    + (beginDate != null ? " AND DataOcorrencia >= '" + beginDate + "'" : "") 
                : " > NOW()")
                + (endDate != null ? " AND DataOcorrencia <= '" + endDate + "'" : "")
                + " order by DataOcorrencia desc;