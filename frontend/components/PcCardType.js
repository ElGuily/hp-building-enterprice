import React from 'react'
import styles from '../styles/PcCardType.module.css'
import Image from "next/image";
import Link from 'next/link';


function PcCardType(props) {
  return (
    <Link href={props.link}>
      <div className={styles.box}>
        <img src={props.img} alt={props.type} layout="fixed" className={styles.img} />

        <span className={styles.span}>{props.type}</span>

      </div>
    </Link>
  )
}

export default PcCardType