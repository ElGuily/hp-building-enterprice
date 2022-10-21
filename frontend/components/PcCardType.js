import React from 'react'
import styles from '../styles/PcCardType.module.css'


function PcCardType(props) {
  return (
    <div className={styles.box}>
        <img src={props.img} alt={props.type} className={styles.img}/>
        <span className={styles.span}>{props.type}</span>
    </div>
  )
}

export default PcCardType